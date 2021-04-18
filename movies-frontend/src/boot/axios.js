import axios from 'axios'
import { Platform } from 'quasar'
import { EventBus } from '../helpers/EventBus'
import HttpStatus from '../helpers/HttpStatus'
import moment from 'moment'

const lastRequestTime = null
const SESSION_TIMOUT_TIME = 5
const devEnvironmentUrl = 'http://localhost:8680'
const prodEnvironmentUrl = devEnvironmentUrl
const apiBaseURL = process.env.DEV ? devEnvironmentUrl : prodEnvironmentUrl

const axiosInstance = axios.create({
  baseURL: apiBaseURL
})

const resolveHiddingLoading = (res) => {
  EventBus.$emit('hide-loading')
  checkRequestTimeout()
  return res
}

function checkRequestTimeout () {
  if (Platform.is.electron && lastRequestTime) {
    if (lastRequestTime.isBefore(moment().subtract(SESSION_TIMOUT_TIME, 'minutes'))) {
      EventBus.$emit('logout')
    }
  }
}

const rejectHiddingLoading = (err) => {
  EventBus.$emit('hide-loading')
  if (err.response && window.navigator.onLine &&
    (err.response.status === HttpStatus.GATWAY_TIMEOUT ||
      err.response.status === HttpStatus.SERVER_NOT_RESPONDING)) {
    EventBus.$emit('connection-error')
  }

  checkRequestTimeout()

  if (err.response && err.response.status === HttpStatus.UNAUTHORIZED) {
    EventBus.$emit('logout')
  }
  return Promise.reject(err)
}

axiosInstance.interceptors.response.use(resolveHiddingLoading, rejectHiddingLoading)

export default ({ Vue }) => {
  Vue.prototype.$axios = axiosInstance
}

export { axiosInstance }

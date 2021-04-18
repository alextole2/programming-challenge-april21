<template>
  <div class="container">
    <div class="center-row">
         <h6> Ratings list </h6>
    </div>
    <div class="center-row ratings_flex">
      <q-input
        counter
        outlined
        bottom-slots
        maxlength="06"
        label="Top"
        v-model="top"
      >
        <template v-slot:append>
          <q-icon
            v-if="top !== ''"
            name="close"
            @click="top = ''"
            class="cursor-pointer"
          />
        </template>
      </q-input>
      <q-btn type="submit"
        label="Search"
        class="search-btn"
        color="primary"
        @click="submit()"/>
    </div>
    <div class="q-pa-md">
      <q-table
        :data="data"
        :columns="columns"
        row-key="name"
      />
    </div>
  </div>
</template>

<script>

import { ratingsService } from 'src/services/RatingsService'

export default {
  data () {
    return {
      top: '',
      columns: [
        {
          name: 'title',
          required: true,
          label: 'Title',
          align: 'left',
          field: row => row.title,
          format: val => `${val}`,
          sortable: true
        },
        {
          name: 'rate',
          required: true,
          label: 'Rated',
          align: 'center',
          field: row => row.rated,
          format: val => `${val}`,
          sortable: true
        }
      ],
      data: []
    }
  },
  computed: {
    topParam () {
      return { text: this.top }
    }
  },
  methods: {
    loadingShow () {
      this.$q.loading.show({
        delay: 300
      })
    },
    loadingHide () {
      this.$q.loading.hide()
    },
    notifySuccess (message) {
      this.$q.notify({
        message: message,
        icon: 'info',
        position: 'top',
        type: 'positive',
        timeout: 1500
      })
    },
    notifyWarning (message) {
      this.$q.notify({
        message: message,
        icon: 'warning',
        type: 'warning',
        position: 'top',
        timeout: 1500
      })
    },
    onSuccess (res) {
      this.notifySuccess('Movies were succefully found')
      this.data = res.data
    },
    isEmpty (value) {
      return value === ''
    },
    submit () {
      const notifyScope = this
      notifyScope.loadingShow()
      const errorMessage = 'Was not found movies'
      const topNotEmpty = !this.isEmpty(this.top)

      if (topNotEmpty) {
        ratingsService.getRatedMoviesByTop(this.top)
          .then((res) => this.onSuccess(res))
          .catch(function () { notifyScope.notifyWarning(errorMessage) })
          .finally(function () { notifyScope.loadingHide() })
      } else {
        notifyScope.notifyWarning('All fields are mandatory to this search')
        notifyScope.loadingHide()
      }
    }
  }
}
</script>

<style lang="stylus">
  .center-row
    display: flex;
    justify-content: center;
  .search-btn
    margin-top: 10px;
    margin-bottom: 30px;
  div.ratings_flex {
      display: flex;
      margin: 5px;
      padding: 5px;
  }
  div > * {
    padding: 0 5px;
  }
</style>

<template>
  <div class="container">
    <div class="row center-row">
        <h6> File to upload </h6>
    </div>
    <div class="row">
      <div class="col-sm-4" />
      <div class="flex">
          <input type="file" id="file" ref="file" v-on:change="handleFileUpload()" />
          <q-btn type="submit"
            label="Save"
            class="flex-align-center"
            color="primary"
            @click="submitFile()"/>
      </div>
      <div class="col-sm-4" />
    </div>
  </div>
</template>

<script>

import { fileService } from 'src/services/FileService'

export default {
  data () {
    return {
      file: ''
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
    submitFile () {
      const notifyScope = this
      if (!this.file) {
        notifyScope.notifyWarning('None file was loaded')
      }
      if (this.file) {
        notifyScope.loadingShow()
        fileService.upload(this.file)
          .then(function () {
            notifyScope.notifySuccess('File succefully uploaded')
          })
          .catch(function () {
            notifyScope.notifyWarning('File was not uploaded')
          }).finally(function () {
            notifyScope.loadingHide()
          })
      }
    },
    handleFileUpload () {
      this.file = this.$refs.file.files[0]
    }
  }
}
</script>
<style lang="stylus">
  .center-row
    display: flex;
    justify-content: center;
  div.flex {
      display: flex;
      border: 1px solid black;
      margin: 5px;
      padding: 5px;
  }
  div > * {
    padding: 0 5px;
  }
</style>

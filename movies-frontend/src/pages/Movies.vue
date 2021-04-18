<template>
  <div class="container">
    <div class="center-row">
         <h6> Movies list </h6>
    </div>
    <div class="center-row movies_flex">
     <q-input
          counter
          outlined
          bottom-slots
          maxlength="04"
          label="Year"
          v-model="year"
        >
          <template v-slot:append>
            <q-icon
              v-if="year !== ''"
              name="close"
              @click="year = ''"
              class="cursor-pointer"
            />
          </template>
        </q-input>
         <q-input
          counter
          outlined
          bottom-slots
          maxlength="255"
          label="Genre"
          v-model="genre"
        >
          <template v-slot:append>
            <q-icon
              v-if="genre !== ''"
              name="close"
              @click="genre = ''"
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

import { moviesService } from 'src/services/MoviesService'

export default {
  data () {
    return {
      year: '',
      genre: '',
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
          name: 'genre',
          required: this.isEmpty,
          label: 'Genres',
          align: 'center',
          field: row => row.genres,
          format: val => `${val}`,
          sortable: true
        }
      ],
      data: []
    }
  },
  computed: {
    yearParam () {
      return { text: this.year }
    },
    genreParam () {
      return { text: this.genre }
    },
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

      const yearAndGenreNotEmpty = !this.isEmpty(this.year) &&
      !this.isEmpty(this.genre)

      if (yearAndGenreNotEmpty) {
        moviesService.getMoviesByYearAndGenre(this.year, this.genre)
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
  div.movies_flex {
      display: flex;
      margin: 5px;
      padding: 5px;
  }
  div > * {
    padding: 0 5px;
  }
</style>

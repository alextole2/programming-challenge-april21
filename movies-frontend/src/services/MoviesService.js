import { axiosInstance } from 'src/boot/axios'

export const moviesService = {
  getMoviesByYearAndGenre
}

const path = '/movies'

async function getMoviesByYearAndGenre (year, genre, params) {
  return (await axiosInstance.get(`${path}/yearAndGenre/${year}/${genre}`, { params }))
}

import { axiosInstance } from 'src/boot/axios'

export const ratingsService = {
  getRatedMoviesByTop
}

const path = '/ratings'

async function getRatedMoviesByTop (limit) {
  return (await axiosInstance.get(`${path}/byTop/${limit}`))
}

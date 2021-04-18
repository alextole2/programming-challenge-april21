
import { axiosInstance } from 'src/boot/axios'

export const fileService = {
  upload
}

const path = '/import'

async function upload (file) {
  const config = { params: {}, headers: { 'Content-Type': 'multipart/form-data' } }
  const formData = new FormData()
  formData.append('file', file)
  return (await axiosInstance.post(path, formData, config)).data
}

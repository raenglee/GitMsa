import axios from 'axios'
import { GLOBAL_URL } from './util.js'

export const URL = `${GLOBAL_URL}/freeboard`

export const saveFreeboard = async (formData) => {
  const token = localStorage.getItem('token') // get token from local storage
  try {
    const res = await axios.post(`${URL}`, formData, {
      Headers: {
        'Content-Type': 'multipart/form-data',
        Authorization: 'Bearer' + token
      }
    })
    return res
  } catch (e) {
    console.log(e)
    return e
  }
}

export const getFreeBoard = async (pageNum) => {
  // console.log(`여기오나`)
  const token = localStorage.getItem('token') // get token from local storage
  if (pageNum == undefined) pageNum = 0

  try {
    const res = await axios.get(`${URL}?pageNum=${pageNum}`, {
      headers: {
        'Content-Type': 'application/json',
        'authorization': 'Bearer ' + token
      }
    })
    return res
  } catch (e) {
    console.log(e)
    return e
  }
}
// theFreeboardInput.vue -> freeboardAPI saveFreeboard 함수 호출

export const getFreeBoardView = async (idx) => {
  console.log(`${URL}/view/${idx}`)
  try {
    const res = await axios.get(`${URL}/view/${idx}`)
    return res
  } catch (e) {
    console.log(e)
    return e
  }
}

export const freeboardDelete = async (idx) => {
  try {
    const res = await axios.delete(`${URL}/delete/${idx}`)
    return res
  } catch (e) {
    console.log(e)
    return e
  }
}

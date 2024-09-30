import axios from 'axios'

const URL = 'http://localhost:10000/user'

export const getUsers = async () => {
  try {
    const res = await axios.get(`${URL}/select`)
    return res
  } catch (e) {
    console.log(e)
    return e
  }
}

export const saveUser = async (item) => {
  try {
    const res = await axios.put(`${URL}/update`, item)
    return res
  } catch (e) {
    console.log(e)
    return e
  }
};

export const deleteUser = () => {}

import axios from 'axios';
import { GLOBAL_URL } from './util.js';

export const URL = `${GLOBAL_URL}/freeboard`;

export const saveFreeboard = async (formData) => {
  try {
    const res = await axios.post(`${URL}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    });
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};

export const getFreeBoard = async (pageNum) => {
  if (pageNum == undefined) pageNum = 0;

  try {
    const res = await axios.get(`${URL}?pageNum=${pageNum}`);
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};

export const getFreeBoardView = async (idx) => {
  console.log(`${URL}/view/${idx}`);
  try {
    const res = await axios.get(`${URL}/view/${idx}`);
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};

export const freeboardDelete = async (idx) => {
  try {
    const res = await axios.delete(`${URL}/delete/${idx}`);
    return res;
  } catch (e) {
    console.log(e);
    return e;
  }
};

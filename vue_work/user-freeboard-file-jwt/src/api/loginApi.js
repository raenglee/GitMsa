import axios from 'axios';
import {GLOBAL_URL} from './util.js';

const login = `${GLOBAL_URL}/login`;
const join = `${GLOBAL_URL}/join`;
const check = `${GLOBAL_URL}/check`;

export const doJoin = async (data) => {
    try {
        const res = await axios.post(join, data,{
            headers: {
                'Content-Type': 'application/json'
            }
        });
        return res;
    } catch (e) {
        console.log(e);
        return e;
    }
}

export const doLogin = async (data) => {
    try {
        const res = await axios.get(`${login}?email=${data.email}&password=${data.password}`);
        console.log(res);
        return res;

    } catch (e) {
        console.log(e);
        return e;
    }
}

export const doLoginCheck = async () => {
    const token = localStorage.getItem('token');
    try {
        const res = await axios.get(`${check}?jwt=${token}`);
        return res;
    } catch (e) {
        console.log(e);
        return e;
    }
}
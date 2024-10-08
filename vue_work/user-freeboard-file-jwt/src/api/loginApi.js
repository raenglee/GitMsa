import axios from 'axios';
import {GLOBAL_URL} from './util.js';

const login = `${GLOBAL_URL}/login`;
const join = `${GLOBAL_URL}/join`;

export const doJoin = async (data) => {
    try {
        const res = await axios.post(join, data);
        return res;
    } catch (e) {
        console.log(e);
        return e;
    }
}

export const doLogin = async (data) => {
    try {
        const res = await axios.get(`${login}?email=${data.email}&password=${data.password}`);
        return res;
    } catch (e) {
        console.log(e);
        return e;
    }
}
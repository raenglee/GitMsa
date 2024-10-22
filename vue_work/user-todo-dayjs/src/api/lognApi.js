import axios from 'axios';

const url = 'http://localhost:20000';

export const login = async (code) => {
	try {
		const res = await axios.get(`${url}/kakao/login?code=${code}`);
		return res.data;
	} catch (err) {
		console.error(err);
		return err;
	}
};
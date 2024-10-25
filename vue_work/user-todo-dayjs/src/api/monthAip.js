import axios from 'axios';

const url = 'http://localhost:20000';

export const saveTodo = async (title, content, selectDate) => {
	const data = {
		title, //변수명이랑 객체가 똑같을땐 안적어도 괜찮음
		content,
		selectDate,
		completed: false,
	};
	const headers = {
		'Content-Type': 'application/json',
		Authorization: `Bearer ${localStorage.getItem('token')}`,
	};
	try {
		const res = await axios.get(`${url}/todo/save`, data, { headers });
		return res;
	} catch (err) {
		console.error(err);
		return err;
	}
};

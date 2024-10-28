import axios from 'axios';

const url = 'http://localhost:20000';

export const saveTodo = async (title, content, selectDate) => {
	const data = {
		title,
		content,
		selectDate,
		completed: false,
	};
	const headers = {
		'Content-Type': 'application/json',
		Authorization: `Bearer ${localStorage.getItem('token')}`,
	};
	try {
		const res = await axios.post(`${url}/todo/save`, data, { headers });
		return res;
	} catch (err) {
		console.error(err);
		return err;
	}
};

export const getTodos = async () => {
	if (localStorage.getItem('token') === undefined || localStorage.getItem('token') === null) return;
	const headers = {
		'Content-Type': 'application/json',
		Authorization: `Bearer ${localStorage.getItem('token')}`,
	};
	try {
		const res = await axios.get(`${url}/todo/findall`, { headers });
		return res;
	} catch (err) {
		console.error(err);
		return err;
	}
};
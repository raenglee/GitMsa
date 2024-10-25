import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
	state: () => ({
		loginCheck: false,
		nickName: '',
		thumbnail: '',
		profileImage: '',
		email: '',
		userId: '',
	}),
	actions: {
		login(data) {
			this.loginCheck = true;
			this.userId = data.userId;
			this.nickName = data.nickname;
			this.thumbnail = data.thumbnail_image;
			this.profileImage = data.profile_image;
			this.email = data.email;
		},
		logout() {
			this.loginCheck = false;
			this.nickName = '';
			this.thumbnail = '';
			this.profileImage = '';
			this.email = '';
			this.userId = '';
		},
	},
});

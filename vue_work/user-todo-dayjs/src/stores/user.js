import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
	// 변수
	state: () => ({
		loginCheck: false,
		nickname: '',
		thumbnail: '',
		profileImage: '',
		email: '',
	}),
	// 함수
	actions: {
		login(data) {
			//login 성공 -> backend 통신
			this.loginCheck = true;
			this.userId = data.userId;
			this.nickname = data.nickname;
			this.thumbnail = data.thumbnail_image;
			this.profileImage = data.profile_image;
			this.email = data.email;
		},
		logout() {
			this.loginCheck = false;
            this.userId = '';
            this.nickname = '';
            this.thumbnail = '';
            this.profileImage = '';
            this.email = '';
		}
	},
});

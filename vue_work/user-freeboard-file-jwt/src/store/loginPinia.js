import { defineStore } from "pinia";

export const useLoginStore = defineStore("login",{
    state:()=>({
        loginCheck : false,
        data: null,
        name: "홍길동"
    }),
    actions:{
        login(data){
            this.loginCheck = true;
            this.name = data.name;
            this.data = data;
        },
        logout(){
            this.loginCheck = false;
            this.name="";
            this.data = null;
        }
    }
});
import { defineStore } from "pinia";
import { register, login } from "@/api/auth";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    loginMessage: "",
    loginId: "not",
  }),
  actions: {
    async fetchRegister(registerUser) {
      try {
        const response = await register(registerUser);
        console.log(response.status);
      } catch (error) {
        console.error("Error fetching apart data:", error);
      }
    },
    async fetchLogin(loginUser) {
      try {
        const response = await login(loginUser);
        console.log(loginUser);
        console.log(response.data);
        this.loginMessage = response.data;
        this.loginId = loginUser.loginId;
      } catch (error) {
        console.error("Error fetching apart data:", error);
      }
    },
    fetchLogout() {
      try {
        this.loginMessage = "";
        this.loginId = "not";
      } catch (error) {
        console.error("Error fetching apart data:", error);
      }
    },
  },
});

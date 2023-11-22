// src/stores/apartStore.js
import { defineStore } from "pinia";
import { listApart, searchByDongCode } from "@/api/apart";

export const useApartStore = defineStore("apart", {
  state: () => ({
    apartList: [],
  }),
  actions: {
    async fetchApartList() {
      try {
        const response = await listApart();
        this.apartList = response.data;
      } catch (error) {
        console.error("Error fetching apart data:", error);
      }
    },
    async fetchApartByDongCode(dongCode) {
      try {
        const response = await searchByDongCode(dongCode);
        this.apartList = response.data;
      } catch (error) {
        console.error("Error fetching apart data:", error);
      }
    },
  },
});

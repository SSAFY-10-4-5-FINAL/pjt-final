// src/stores/apartStore.js
import { defineStore } from "pinia";
import { listApart, searchByDongCode, getApartByAptCode, getStarredAreaa } from "@/api/apart";

export const useApartStore = defineStore("apart", {
  state: () => ({
    apartList: [],
    areaList: [],
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
    async fetchApartByAptCode(aptCode) {
      try {
        const response = await getApartByAptCode(aptCode);
        this.apartList = [response.data.aptDto];
      } catch (error) {
        console.error("Error fetching apart data:", error);
      }
    },
    async fetchStarredArea(userId) {
      try {
        this.areaList = [];
        const response = await getStarredAreaa(userId);
        const dongCodeList = response.data;
        // 병렬로 각 dongCode에 대한 요청을 보내고 응답을 기다림
        const requests = dongCodeList.map(async (dongCode) => {
          try {
            const result = await searchByDongCode(dongCode);
            // result를 처리하거나 저장할 수 있음
            this.areaList.push([
              result.data[0].sidoName + " " + result.data[0].gugunName,
              result.data[0].roadName,
              dongCode,
            ]);
          } catch (error) {
            console.error(`Error fetching data for dongCode ${dongCode}:`, error);
          }
        });
      } catch (error) {
        console.error("Error fetching apart data:", error);
      }
    },
  },
});

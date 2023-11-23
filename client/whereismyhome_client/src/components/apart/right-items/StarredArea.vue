<script setup>
import { ref, onMounted, watch } from "vue";
import { useRoute } from "vue-router";
import { useApartStore } from "@/stores/apartStore";
import ApartBrief from "./ApartBrief.vue";

const route = useRoute();
const apartStore = useApartStore();

const getStarredArea = (userId) => {
  apartStore.fetchStarredArea(userId);
};

// 초기 로딩 시와 라우트 변경 시 데이터 호출
const loadData = () => {
  getStarredArea(route.params.userId);
};

onMounted(() => {
  // 초기 로딩 시 데이터 호출
  loadData();
});
</script>

<template>
  <div v-for="area in apartStore.areaList" class="starred-area-wrap">
    <router-link
      :to="{ name: 'ApartList', params: { dongCode: area[2] } }"
      style="text-decoration: none; color: inherit">
      <h2>
        {{ area[0] }}
      </h2>
      {{ area[1] }}
    </router-link>
  </div>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap");
.starred-area-wrap {
  font-family: "Noto Sans KR", sans-serif;
  border: 1px solid #708090;
  overflow: hidden;
  width: 100%;
}
</style>

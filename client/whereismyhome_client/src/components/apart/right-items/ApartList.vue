<script setup>
import { onMounted, watch } from "vue";
import { useRoute } from "vue-router";
import { useApartStore } from "@/stores/apartStore";
import ApartBrief from "./ApartBrief.vue";

const route = useRoute();
const dongCode = route.params.dongCode;
const apartStore = useApartStore();

const fetchApartData = (dongCode) => {
  apartStore.fetchApartByDongCode(dongCode);
};

// 초기 로딩 시와 라우트 변경 시 데이터 호출
const loadData = () => {
  fetchApartData(route.params.dongCode);
};

// 라우트가 변경될 때마다 데이터 호출
watch(
  () => route.params.dongCode,
  (newDongCode) => {
    fetchApartData(newDongCode);
  }
);

onMounted(() => {
  // 초기 로딩 시 데이터 호출
  loadData();
});
</script>

<template>
  <ApartBrief
    v-for="apart in apartStore.apartList"
    :key="apart.aptCode"
    :apart="apart"></ApartBrief>
</template>

<style scoped></style>

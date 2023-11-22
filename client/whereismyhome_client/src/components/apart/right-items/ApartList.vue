<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { searchByDongCode } from "@/api/apart";
import ApartBrief from "./ApartBrief.vue";

const route = useRoute();
const router = useRouter();

onMounted(() => {
  getApartByDongCode();
});

// Data
const dongCode = route.params.dongCode; // list에서 router link를 통해 받아온 params
const apartList = ref([]);

// Method

const getApartByDongCode = async () => {
  const response = await searchByDongCode(dongCode);
  apartList.value = response.data;
  console.log(apartList.value);
};
</script>

<template>
  <ApartBrief v-for="a in apartList" :key="a.aptCode" :apart="a"></ApartBrief>
</template>
<style scoped></style>

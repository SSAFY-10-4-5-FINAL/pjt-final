<script setup>
import { ref, onMounted } from "vue";
import { listApart } from "@/api/apart.js";
import ApartBrief from "./ApartBrief.vue";

onMounted(() => {
  getApartList();
});

// Data
const apartList = ref([]);

// Function
const getApartList = async () => {
  const response = await listApart();
  apartList.value = response.data;
};
</script>
<template>
  <ApartBrief
    v-for="(apart, index) in apartList"
    :key="apart.aptCode"
    :index="index"
    :apart="apart" />
</template>
<style scoped></style>

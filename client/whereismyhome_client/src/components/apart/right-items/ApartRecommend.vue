<script setup>
import { ref, onMounted } from "vue";
import { listApart } from "@/api/apart.js";
import { useApartStore } from "@/stores/apartStore";
import ApartBrief from "./ApartBrief.vue";

const apartStore = useApartStore();

onMounted(() => {
  apartStore.fetchApartList();
});

// Data

// Function
</script>
<template>
  <ApartBrief
    v-for="(apart, index) in apartStore.apartList"
    :key="apart.aptCode"
    :index="index"
    :apart="apart" />
</template>
<style scoped></style>

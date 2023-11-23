<script setup>
import { onMounted } from "vue";
import { useRoute } from "vue-router";
import { useApartStore } from "@/stores/apartStore";
import ApartBrief from "./ApartBrief.vue";

const route = useRoute();
const dongCode = route.params.dongCode;
const apartStore = useApartStore();

onMounted(() => {
  apartStore.fetchApartByDongCode(dongCode);
});
</script>

<template>
  <ApartBrief
    v-for="apart in apartStore.apartList"
    :key="apart.aptCode"
    :apart="apart"
  ></ApartBrief>
</template>

<style scoped></style>

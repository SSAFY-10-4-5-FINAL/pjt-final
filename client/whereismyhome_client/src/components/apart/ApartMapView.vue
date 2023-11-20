<script setup>
import { ref } from "vue";
import VKakaoMap from "@/components/common/VKakaoMap.vue";
const { VITE_OPEN_API_SERVICE_KEY } = import.meta.env;

const aparts = ref([]);
</script>
<template><VKakaoMap :aparts="aparts" /></template>
<style scoped></style>

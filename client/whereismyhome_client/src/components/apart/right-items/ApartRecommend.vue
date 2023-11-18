<script setup>
import { ref } from "vue";
import ApartBrief from "./ApartBrief.vue";

const test_count = ref(5);
</script>
<template><ApartBrief v-for="() in test_count" /></template>
<style scoped></style>

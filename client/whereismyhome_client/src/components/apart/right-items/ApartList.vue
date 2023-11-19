<script setup>
import { ref } from "vue";
import ApartBrief from "./ApartBrief.vue";

const test_count = ref(10);
</script>
<template>
  <div>리스트 시작</div>
  <ApartBrief v-for="() in test_count" />
</template>
<style scoped></style>

<script setup>
import { ref } from "vue";
import ApartSearchItem from "./ApartSearchItem.vue";

// Data
const testCount = ref(10);
</script>

<template>
  <div v-for="{} in testCount"><ApartSearchItem /></div>
</template>

<style scoped></style>

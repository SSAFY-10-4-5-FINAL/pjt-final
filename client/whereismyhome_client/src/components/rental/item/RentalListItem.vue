<script setup>
// Data
const props = defineProps({ index: Number, rentalboard: Object });

console.log(props.index);
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ index + 1 }}</th>
    <td class="text-start">
      <router-link
        :to="{
          name: 'RentalDetail',
          params: { articleNo: rentalboard.articleNo },
        }"
        class="article-title link-dark">
        {{ rentalboard.subject }}
      </router-link>
    </td>
    <td>{{ rentalboard.userId }}</td>
    <td>{{ rentalboard.hit }}</td>
    <td>{{ rentalboard.registerTime }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>

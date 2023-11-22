<script setup>
// Data
const props = defineProps({ rentalboard: Object });
console.log(props.rentalboard);
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ rentalboard.articleNo }}</th>
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

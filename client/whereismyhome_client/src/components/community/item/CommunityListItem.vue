<script setup>
// Data
const props = defineProps({ board: Object });
console.log(props.board);
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ board.articleNo }}</th>
    <td class="text-start">
      <router-link
        :to="{
          name: 'CommunityDetail',
          params: { articleNo: board.articleNo },
        }"
        class="article-title link-dark">
        {{ board.subject }}
      </router-link>
    </td>
    <td>{{ board.userId }}</td>
    <td>{{ board.hit }}</td>
    <td>{{ board.registerTime }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>

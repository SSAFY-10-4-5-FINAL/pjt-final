<script setup>
// Data
const props = defineProps({ noticeboard: Object });
console.log(props.noticeboard);
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ noticeboard.articleNo }}</th>
    <td class="text-start">
      <router-link
        :to="{
          name: 'NoticeDetail',
          params: { articleNo: noticeboard.articleNo },
        }"
        class="article-title link-dark">
        {{ noticeboard.subject }}
      </router-link>
    </td>
    <td>{{ noticeboard.userId }}</td>
    <td>{{ noticeboard.hit }}</td>
    <td>{{ noticeboard.registerTime }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>

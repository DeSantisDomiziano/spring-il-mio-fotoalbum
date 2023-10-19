<script>
import axios from 'axios';
export default {
  data() {
    return {
      API_URL: "http://localhost:8080/api",
      photos: null,
      message: ""
    }
  },
  methods: {
    getPhotos() {
      axios.get(this.API_URL + "/photos")
        .then((res) => {
          this.photos = res.data
          console.log(this.photos)
        })
        .catch((e) => {
          console.log(e)
        })
    },
    sendMessage(){

      axios.post(this.API_URL + "/message/send", 
        this.message,
      );
    }
  },
  mounted() {
    this.getPhotos()

  }
}
</script>



<template>

  <div>
    <form @submit.prevent="sendMessage">
    <input v-model="message" placeholder="Inserisci il messaggio" />
    <button type="submit">Invia</button>
  </form>
  </div>

  <div v-for="photo in photos">

    <div v-if="photo.visible">
      <h1>{{ photo.title }}</h1>
      <p>{{ photo.description }}</p>
      <img :src="photo.url" :alt="photo.name">
  
      <p v-if="photo.categories" class="m-0">Categorie:
        <span v-for="(category, i) in photo.categories">{{ category.nameCategory }}
          <span v-if="i < photo.categories.length - 1"> - </span>
        </span>
      </p>
      <hr>

    </div>

  </div>
</template>

<style scoped></style>

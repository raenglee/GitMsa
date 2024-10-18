<template>
  <nav class="bg-white shadow-md fixed w-full z-10">
    <div class="container mx-auto px-4 sm:px-6 lg:px-8">
      <div class="flex justify-between items-center py-4">
        <!-- Logo -->
        <div class="text-2xl font-bold text-gray-800">JU TODO</div>
        <!-- Hamburger Menu (for mobile) -->
        <div class="sm:hidden">
          <button @click="menuDisplay" id="menuDisplay" class="text-gray-800 focus:outline-none">
            <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16m-7 6h7"></path>
            </svg>
          </button>
        </div>
        <!-- Navigation Links (hidden on small screens) -->
        <div class="hidden sm:flex space-x-8 text-gray-800">
          <RouterLink to="/" class="hover:text-blue-500">Home</RouterLink>
          <RouterLink to="/about" class="hover:text-blue-500">ABOUT</RouterLink>
          <RouterLink to="/month" class="hover:text-blue-500">MONTH</RouterLink>
					<RouterLink to="/login" class="hover:text-blue-500">LOGIN</RouterLink>
        </div>
      </div>
      <!-- Mobile Menu (hidden by default) -->
			 <template v-if="mobileMenu">
      <div id="mobile-menu" class="bg-white">
        <RoterLink to="/" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">Home</RoterLink>
        <RoterLink to="/about" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">ABOUT</RoterLink>
        <RoterLink to="/month" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">MONTH</RoterLink>
				<RoterLink to="/login" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">LOGIN</RoterLink>
      </div>
		</template>
    </div>
  </nav>
</template>

<script setup>
import {ref} from 'vue';
import { RouterLink } from 'vue-router';

const mobileMenu=ref(false);

const menuDisplay=() => {
	mobileMenu.value =!mobileMenu.value;
}

</script>

<style lang="scss" scoped>

</style>
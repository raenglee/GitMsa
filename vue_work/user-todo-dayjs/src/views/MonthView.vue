<script setup>
import { ref, watch, watchEffect } from 'vue';
import dayjs from 'dayjs';
import { saveTodo, getTodos } from '@/api/monthAip';

// import utc from 'dayjs/plugin/utc';
// import timezone from 'dayjs/plugin/timezone';

// dayjs.extend(utc);
// dayjs.extend(timezone);

const isDisabled = ref(false);

const now = ref(dayjs());
const columns = ref([]);
const groupColumns = ref([]);

// selectDate 가 값이 null일때는 false 값이 date 로 바뀌면 true;
const selectDate = ref(null);
const title = ref('');
const content = ref('');

const todos = ref([]);

const toast = ref(false);

const setDate = (e) => {
	selectDate.value = e.target.value;
};

//세이브 할 때
const doSave = async () => {
	isDisabled.value = true; // 저장하기 전엔 disabled가 false, 저장할땐 true
	// 백엔드로 넘겨줘야한다
	// console.log('save', title.value, content.value, selectDate.value);
	await saveTodo(title.value, content.value, selectDate.value);
	await doGet();

	title.value = '';
	content.value = '';
	toast.value = true; // false값을 true로 변경 => 등록하였습니다 창이 뜸

	setTimeout(() => {
		toast.value = false;
		isDisabled.value = true;
	}, 3000); // 3000(3초)뒤에 {} 함수 실행
};

const doGet = async () => {
	const res = await getTodos();
	if (res.status == '200') {
		const newData = res.data;
		// 새로운 할 일들을 가지고 와서 원래의 할 일과 다르면 비교해서 작동
		if (JSON.stringify(todos.value) !== JSON.stringify(newData)) todos.value = res.data;
	}
};

const subMonth = () => {
	now.value = dayjs(now.value).subtract(1, 'month');
};
const addMonth = () => {
	now.value = dayjs(now.value).add(1, 'month');
};
const selectDateFn = (date) => {
	console.log('dateClick', dayjs(date).format('YYYY-MM-DD'));
	selectDate.value = dayjs(date).format('YYYY-MM-DD');
};

watch(
	[now, todos],
	async () => {
		await doGet();

		columns.value = []; // 원래 있던 값 제거
		groupColumns.value = []; // 원래 있던 값 제거
		// 제일 처음 로딩 할때는 now는 현재 달력...
		const startday = dayjs(now.value).startOf('month');
		const lastday = dayjs(now.value).endOf('month');
		const startdayOfWeek = startday.get('day');
		const lastdayOfWeek = lastday.get('day');

		// 저번달에 날짜 추가
		for (let i = 1; i <= startdayOfWeek; i++) {
			columns.value.unshift(dayjs(startday).subtract(i, 'day'));
		}
		// 현재 달력에 날짜 추가
		for (let i = 0; i < lastday.get('date'); i++) {
			columns.value.push(dayjs(startday).add(i, 'day'));
		}
		// 다음달에 날짜 추가
		for (let i = 1; i <= 6 - lastdayOfWeek; i++) {
			columns.value.push(dayjs(lastday).add(i, 'day'));
		}

		groupColumns.value.push(columns.value.slice(0, 7));
		groupColumns.value.push(columns.value.slice(7, 14));
		groupColumns.value.push(columns.value.slice(14, 21));
		groupColumns.value.push(columns.value.slice(21, 28));
		groupColumns.value.push(columns.value.slice(28, 35));
	},
	{
		immediate: true, // 현재페이지 처음 로딩 될때 도 실행
		deep: true, // 안에 값이 객체이면 객체 안에 변수도 변경 될때 watch안에 있는 함수 실행
	},
);

// watchEffect(async () => {
// 	const res = await getTodos();
// 	if (res.status == 200) {
// 		todos.value = res.data; // 새로고침 안해도 다시 가져오는것
// 	}
// });
</script>

<template>
	<div class="pt-32">
		<h1>MonthView</h1>
		<main class="flex justify-center">
			<div class="max-w-lg w-full bg-white shadow-md rounded-lg p-4">
				<h1 class="text-xl font-bold text-center mb-4">
					<button @click="subMonth()" class="mr-2"><i class="fas fa-arrow-left"></i></button>
					{{ now.format('YYYY년 MM월') }}
					<button @click="addMonth()" class="ml-2"><i class="fas fa-arrow-right"></i></button>
				</h1>
				<div class="grid grid-cols-7 gap-2 text-center text-gray-600">
					<div class="p-2 px-4 text-red-600">일</div>
					<div class="p-2 px-4">월</div>
					<div class="p-2 px-4">화</div>
					<div class="p-2 px-4">수</div>
					<div class="p-2 px-4">목</div>
					<div class="p-2 px-4">금</div>
					<div class="p-2 px-4 text-blue-500">토</div>
				</div>
				<div class="grid grid-cols-7 gap-2" v-for="group in groupColumns" :key="group.length">
					<div
						@click="selectDateFn(column)"
						v-for="(column, index) in group"
						:key="column.format('YYYY-MM-DD')"
						class="text-center p-2 hover:bg-blue-200 cursor-pointer"
						:class="{
							'text-red-600': index % 7 == 0,
							'text-blue-600': index % 7 == 6,
							'opacity-20': !column.isSame(now, 'month'),
						}"
					>
						<span>
							{{ column.get('date') }}
							<template v-for="todo in todos" :key="todo">
								<div
									class="odd: text-blue-300 even:text-red-200 rounded"
									:class="{ 'bg-red-500': todo.completed == '0', 'bg-blue-500': todo.completed == '1' }"
									v-if="todo.selectDate == column.format('YYYY-MM-DD')"
								>
									<span>{{ todo.title }}</span>
								</div>
							</template>
						</span>
					</div>
				</div>
			</div>
		</main>
		<div class="flex justify-center my-5" :class="{ hidden: !selectDate }">
			<div class="max-w-lg w-full bg-white shadow-md rounded-lg p-4">
				<h2 class="text-2xl font-bold text-center mb-4">할일 등록</h2>
				<form @submit.prevent="doSave">
					<div class="mb-4">
						<label for="task" class="block text-gray-700 text-sm font-bold mb-2">할일 제목</label>
						<input
							v-model="title"
							type="text"
							id="task"
							placeholder="할일 제목을 입력하세요"
							class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
							required
						/>
					</div>

					<div class="mb-4">
						<label for="description" class="block text-gray-700 text-sm font-bold mb-2">상세 설명</label>
						<textarea
							v-model="content"
							id="description"
							rows="4"
							placeholder="상세 설명을 입력하세요"
							class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
						></textarea>
					</div>

					<div class="mb-6">
						<label for="due-date" class="block text-gray-700 text-sm font-bold mb-2">마감일</label>
						<input
							@change="selectDate.value"
							v-model="selectDate"
							type="date"
							id="due-date"
							class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
						/>
					</div>

					<div class="flex items-center justify-center">
						<button
							:disabled="isDisabled"
							type="submit"
							class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline disabled:opacity-50 disabled:cursor-not-allowed"
						>
							등록하기
						</button>
					</div>
				</form>
			</div>
		</div>
		<template v-if="toast">
			<div class="toast">등록하였습니다.</div>
		</template>
	</div>
</template>

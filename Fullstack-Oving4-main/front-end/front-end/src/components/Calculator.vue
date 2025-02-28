<script setup lang="ts">
import { ref } from 'vue'
const buttonStrings = ['7', '8', '9', '+', '4', '5', '6', '-', '1', '2', '3', '*', 'C', '0', '=', '/']

const inputA = ref('')
const inputB = ref('')  
const operator = ref('')

const output = ref('')
const state = ref('')
const display = ref('')

const buttonClicked = (buttonString: string) => {

  // if number is pressed
  if (!isNaN(Number(buttonString))) {
    switch (state.value) {
      case 'inputA':
        inputA.value += buttonString; break;
      case 'inputB':
        inputB.value += buttonString; break;
      default:
        inputA.value += buttonString;
        state.value = 'inputA';
    }
  }

  // if operator is pressed
  else if (['+', '-', '*', '/'].includes(buttonString)) {
    operator.value = buttonString;
    state.value = 'inputB';
  } 

  // if clear is pressed
  else if (buttonString === 'C') {
    inputA.value = ''
    inputB.value = ''
    operator.value = ''
    state.value = 'inputA'
  }
}

const displayText = () => {
  if (inputA.value === '' && inputB.value === '') {
    return '0'
  }
  return inputA.value + ' ' + operator.value + ' ' + inputB.value
}



</script>

<template>
  <div id = "calc">
    <div id="calc_display">
      <label>{{ displayText() }} </label>
    </div>
    <div id="calc_buttons">
      <button v-for="buttonString in buttonStrings" :key="buttonString" @click="buttonClicked(buttonString)">
        {{ buttonString }}
      </button>
    </div>
  </div>
</template>

<style>
#calc_display {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2em;
  margin: 1em;
  width: 300px;
  background-color: lightgray;
  border-radius: 10px;
  border: 4px solid #282c34;
  padding: 10px;
  color: #282c34;
}
#calc {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 1em;
  color: white;
}
#calc_buttons {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 10px;
  margin: 1em;
  button {
    background-color: #282c34;
    border: none;
    border-radius: 10px;
    padding: 20px;
    font-size: 1.5em;
    cursor: pointer;

  }
  button:hover {
    background-color: deepskyblue;
  }
}
</style>

class Calculator{
  constructor(previousOperandTextElement, currentOperandTextElement)
  {
    this.previousOperandTextElement = previousOperandTextElement
    this.currentOperandTextElement = currentOperandTextElement
  }

  clear()
  {
    this.currentOperand = ''
    this.previousOperand = ''
    this.operation = undefined
  }

  delete()
  {

  }
  
  appendNumber(number)
  {
    this.currentOperand = number
  }
  
  chooseOperation(operation)
  {

  }

  compute()
  {

  }

  updateDisplay()
  {
    this.currentOperandTextElement.innerText = this.currentOperand
  }

}


const numberButtons = document.querySelectorAll('[data-number]')
const operationButtons = document.querySelectorAll('[data-operation]')
const equalButton = document.querySelector('[data-equal]')
const clearButton = document.querySelectorAl('[data-allclear]')
const deleteButton = document.querySelector('[data-delete]')
const previousOperandTextElement = document.querySelector('[data-previous-operand]')
const currentOperandTextElement = document.querySelector('[data-current-operand]')

const calculator = new Calculator(previousOperandTextElement, currentOperandTextElement)

numberButtons.forEach(button => {
  button.addEventListener('click', () => {
    calculator.appendNumber(button.innerText)
    calculator.updateDisplay()
  })
})
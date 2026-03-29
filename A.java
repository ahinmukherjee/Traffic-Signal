<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Guess The Number</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h1>🎮 Guess The Number</h1>
    <p>Guess a number between <b>1 - 100</b></p>

    <input type="number" id="guessInput" placeholder="Enter your guess">
    <button onclick="checkGuess()">Check</button>

    <p id="message"></p>
    <p id="attempts">Attempts: 0</p>

    <button class="reset" onclick="resetGame()">🔄 Reset</button>
</div>

<script src="script.js"></script>
</body>
</html>


  body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
    background: white;
    padding: 30px;
    border-radius: 15px;
    text-align: center;
    width: 300px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.3);
    animation: fadeIn 1s ease-in-out;
}

h1 {
    margin-bottom: 10px;
}

input {
    width: 80%;
    padding: 10px;
    margin: 10px 0;
    border-radius: 10px;
    border: 2px solid #ccc;
    outline: none;
    transition: 0.3s;
}

input:focus {
    border-color: #667eea;
    box-shadow: 0 0 10px #667eea;
}

button {
    padding: 10px 20px;
    border: none;
    border-radius: 10px;
    background: #667eea;
    color: white;
    cursor: pointer;
    margin: 5px;
    transition: 0.3s;
}

button:hover {
    background: #5a67d8;
    transform: scale(1.05);
}

.reset {
    background: #e53e3e;
}

.reset:hover {
    background: #c53030;
}

#message {
    font-weight: bold;
    margin-top: 10px;
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(-20px);}
    to { opacity: 1; transform: translateY(0);}
  }


let randomNumber = Math.floor(Math.random() * 100) + 1;
let attempts = 0;

function checkGuess() {
    let userGuess = document.getElementById("guessInput").value;
    let message = document.getElementById("message");

    if (userGuess === "") {
        message.innerText = "⚠️ Please enter a number!";
        return;
    }

    attempts++;
    document.getElementById("attempts").innerText = "Attempts: " + attempts;

    userGuess = Number(userGuess);

    if (userGuess === randomNumber) {
        message.innerText = "🎉 Correct! You guessed it!";
        message.style.color = "green";
    } else if (userGuess > randomNumber) {
        message.innerText = "📉 Too High!";
        message.style.color = "red";
    } else {
        message.innerText = "📈 Too Low!";
        message.style.color = "orange";
    }
}

function resetGame() {
    randomNumber = Math.floor(Math.random() * 100) + 1;
    attempts = 0;

    document.getElementById("attempts").innerText = "Attempts: 0";
    document.getElementById("message").innerText = "";
    document.getElementById("guessInput").value = "";
}

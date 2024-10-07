<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Point Area Check</title>
    <link rel="stylesheet" href="./style.css">
    <style>
        body {
            background-image: url('images/bg.jpg');
            background-size: cover; 
            background-position: center; 
        }
    </style>
</head>
<body>

    <section class="container">

        <div class="header">
            <h1>
                Student Name: Степан Попов | Group: P3234 | Variant: 413044
            </h1>
            <hr class="hr-shadow">
        </div>

        <div class="main">
            <form id="pointForm" action="controller" method="post" onsubmit="return validateForm()">
                <div class="input-field">
                    <label for="x">X Coordinate:</label>
                    <span class="input">
                        <input type="number" id="x" name="x" placeholder="-4 ... 4" required step="any">
                    </span>
                </div>
                <div class="input-field">
                    <label for="y">Y Coordinate:</label>
                    <input type="number" id="y" name="y" placeholder="-5 ... 3" required step="any">
                </div>
                <div class="input-field">
                    <label for="r">R Value:</label>
                    <input type="number" id="r" name="r" placeholder="1 ... 4" required step="any">
                </div>
                <div id="error-message"></div>
                <button type="submit">Send results!</button>
            </form>

            <div class="canva">
                <svg id="graph" viewBox="-100 -100 200 200" width="400" height="400" style="background-color: white;">
                    <rect x="-100" y="0" width="100" height="50" fill="blue" />
                    <path d="M0,0 L50,0 A50,50 0 0 1 0,50 Z" fill="blue" />
                    <polygon points="0,0 -50,0 0,-50" fill="blue" />
                    <line x1="-100" y1="0" x2="100" y2="0" stroke="black" />
                    <line x1="0" y1="-100" x2="0" y2="100" stroke="black" />
                    <text x="95" y="-5" font-size="10" fill="black">R</text>
                    <text x="50" y="-5" font-size="10" fill="black">R/2</text>
                    <text x="-50" y="-5" font-size="10" fill="black">-R/2</text>
                    <text x="-95" y="-5" font-size="10" fill="black">-R</text>
                    <text x="5" y="-95" font-size="10" fill="black">R</text>
                    <text x="5" y="-45" font-size="10" fill="black">R/2</text>
                    <text x="5" y="45" font-size="10" fill="black">-R/2</text>
                    <text x="5" y="95" font-size="10" fill="black">-R</text>

                    <circle cx="20" cy="20" id="target-dot" r="3" stroke="white" fill="rgb(222, 159, 66)"></circle>
                </svg>
            </div>
        </div>

    </section>

    <script src="script.js"></script>

</body>
</html>

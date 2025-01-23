# CipherGuess - Word Guessing Game

**CipherGuess** is a word guessing game where players need to guess a randomly chosen word by guessing one letter at a time. The game provides a limited number of chances to make guesses, and it displays the word with underscores for unguessed characters. When all characters are guessed correctly or when all tries are exhausted, the game ends.

---

## Features

- Random word selection from a predefined list.
- Users can guess one letter at a time.
- The game shows the word with blanks for unguessed letters.
- Tracks and displays the number of remaining tries.
- Displays success and failure messages.
- Option to restart the game after completion.

---

## Technologies Used

- **Spring Boot** - Backend framework for handling game logic and requests.
- **Thymeleaf** - Template engine to render dynamic HTML views.
- **Java** - Programming language for the backend.
- **HTML/CSS** - Frontend technologies for game interface.
- **JavaScript** - Client-side interactivity (optional for further enhancements).

---

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

- **JDK 17+** - Java Development Kit
- **Maven** - For project build and dependencies
- **Spring Boot** - For the application framework
- **Git** - For version control

### Installation

1. **Clone the repository**:

```bash
git clone https://github.com/yourusername/CipherGuess.git

Navigate to the project directory:
bash
Copy
Edit
cd CipherGuess
Build the project using Maven:
bash
Copy
Edit
mvn clean install
Run the application:
bash
Copy
Edit
mvn spring-boot:run
The application should now be running on http://localhost:8080.

Usage
Visit the home page at http://localhost:8080/game-home.
Enter a single letter guess and click Try.
If you guess correctly, the word will be revealed. If not, the number of remaining tries decreases.
Once all tries are used or the word is guessed, the option to Restart the Game will be displayed.
Click the Restart Game button to play again.
File Structure
arduino
Copy
Edit
CipherGuess/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── rakshan/
│   │   │   │       └── CipherGuess/
│   │   │   │           ├── controllers/
│   │   │   │           ├── services/
│   │   │   │           ├── utils/
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   │   └── game-home-page.html
│   │   │   ├── static/
│   │   │   │   └── css/
│   │   │   │       └── style.css
│   ├── application.properties
├── README.md
Contributing
Feel free to fork the repository and submit pull requests for bug fixes, improvements, or new features.

Steps for contributing:
Fork the repository
Create a new branch (git checkout -b feature-branch)
Commit your changes (git commit -m 'Add new feature')
Push to your branch (git push origin feature-branch)
Open a pull request

License
This project is licensed under the MIT License - see the LICENSE file for details.

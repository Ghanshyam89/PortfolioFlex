# PortfolioFlex -  Show your work at one place

Welcome to OpenForWork, a professional profile building website that allows users to create a comprehensive portfolio aggregator. This project caters to developers, designers, content specialists, and product managers, facilitating easy integration with platforms like GitHub, StackOverflow, Behance, and more.

## Features

- **Seamless Onboarding:** Quick and easy onboarding process, with the option to import data from LinkedIn or manually enter basic details.

- **Profile Customization:** Users can showcase their skills by connecting accounts from various platforms based on their profession (e.g., GitHub for developers, Behance for designers).

- **Media Integration:** Add a brief video testimonial (less than 3 minutes) to introduce yourself, share achievements, and express preferences.

- **Project Showcase:** Highlight your projects with details such as title, description, cover images, links, and demo videos.

## Tech Stack

- **Backend (Java - Spring Boot):** Handles data storage, authentication, and third-party API integrations.
  
- **Frontend (Angular):** Provides an intuitive and interactive user interface for profile creation and project management.

- **Database (MySQL):** Efficiently stores user profiles, project details, and authentication data.

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/Ghanshyam89/PortfolioFlex.git
   ```

2. Set up the backend:
   - Navigate to the `backend` directory.
   - Configure your database connection in `application.properties`.
   - Run the Spring Boot application:
     ```bash
     ./mvnw spring-boot:run
     ```

3. Set up the frontend:
   - Navigate to the `frontend` directory.
   - Install dependencies:
     ```bash
     npm install
     ```
   - Run the Angular application:
     ```bash
     ng serve
     ```

4. Access the application:
   - Open your browser and go to `http://localhost:4200`.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code.

Happy coding! 🚀

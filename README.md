# Overview
App to track garden work and plants by a short text and a picture.

Frontend
- Angular

Backend
- Java Spring

Database
- PostgreSQL

CI/CD
- Build and Deployment by Github Actions

## Functions
- Show entries
- Create/Modify/Delete entry
- Search for entries by full text search
- Switch readonly and edit mode

# Hosting
The angular frontend is hosted on azure as a WebApp in a container and connects to the backend api.
Java Spring backend and postgres database are also hosted as a containerized WebApp on Azure. Both frontend and backend are managed by docker compose. 

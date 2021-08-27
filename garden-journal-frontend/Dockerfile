# stage 1 - build output
FROM node:latest as node
WORKDIR /garden-journal-frontend
COPY . .
RUN npm install
RUN npm run build --prod

# stage 2 - run app
FROM nginx:alpine
COPY --from=node /garden-journal-frontend/dist/garden-journal-frontend /usr/share/nginx/html
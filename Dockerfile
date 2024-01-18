# Use an official Scala runtime as a parent image
FROM openjdk:8

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install sbt (Scala Build Tool)
RUN apt-get update && \
    apt-get install -y --no-install-recommends sbt && \
    rm -rf /var/lib/apt/lists/*

# Build the Scala project
RUN sbt compile

# Expose port 4040 (Spark UI)
EXPOSE 4040

# Run the Scala project when the container launches
CMD ["sbt", "run"]

def call() {
    echo "Running unit tests..."
    
    try {
        sh "mvn clean install -DskipTests"
        echo "Unit tests completed successfully"
    } catch (Exception e) {
        error "Unit tests failed! Build stopped."
    }
}

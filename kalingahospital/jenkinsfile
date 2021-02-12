node {
     
  stage('Git-Checkout') {
   git 'https://github.com/Shyamjith06/Hospital.git'
  }
    
 def project_path="kalingahospital"
 
 dir(project_path) {
    
  stage('Maven-Clean') {
   sh 'mvn clean'
  }
    
 stage('Maven-Compile') {
   sh 'mvn compile'
 }
   stage('Maven-Package') {
   sh 'mvn package'
  } 
}
}


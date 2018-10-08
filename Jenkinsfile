pipeline {
   agent any
    stages {
       stage('#1 Git') {
            steps {
                git 'https://github.com/brunohafonso95/desafio-devops.git'
            }  
       }
       stage('#2 Testes') { 
            steps {
               sh 'mvn test'  
            }
        }
    }
}

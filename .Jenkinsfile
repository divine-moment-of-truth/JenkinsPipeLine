pipeline
{
	agent any
	
	stages
	{
		stage('Build')
		{
			steps
			{
				bat "mvn clean"
			}
		}
		
		stage('Deploy')
		{
			steps
			{
				echo "Deploying the code'
			}
		}
		
		stage('Testing')
		{
			steps
			{
				bat "mvn test"
			}	
		}
		
		stage('Unit Testing')
		{
			steps
			{
				bat "mvn compile"
			}
		}
		
		stage('Release')
		{
			steps
			{
				echo 'Releasing the project'
			}	
		}
	}
}
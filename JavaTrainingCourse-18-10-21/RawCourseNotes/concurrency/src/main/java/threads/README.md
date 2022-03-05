# Simple Thread Exercise

I want you to code a Runnable to which a message can be passed. Inside the run method
you should write the message to stdout 10 times.

You should then spawn two threads using your Runnable. Pass the first a message of 
PING and the second a message of PONG. Then start each one. Run it several times
and check for interleaving of the output.
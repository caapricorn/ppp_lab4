stop-dfs.sh
stop-yarn.sh
sudo /etc/init.d/ssh restart
ssh-add
rm -rf ~/hdata/namenode ~/hdata/datanode
hdfs namenode -format
start-dfs.sh
start-yarn.sh
hadoop jar ~/hadoop-2.10.1/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.10.1.jar pi 2 5

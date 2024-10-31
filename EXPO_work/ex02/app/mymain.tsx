import React from 'react';
import { View, Text, StyleSheet, TouchableOpacity, ScrollView } from 'react-native';
import { FontAwesome } from '@expo/vector-icons';

export default function MyMain() {
  return (
    <View style={styles.container}>
      {/* Header */}
      <View style={styles.header}>
        <Text style={styles.teamName}>명회팀</Text>
        <FontAwesome name="user-circle" size={28} color="white" style={styles.userIcon} />
      </View>

      {/* Search Bar */}
      <View style={styles.searchBar}>
        <FontAwesome name="search" size={20} color="#ccc" />
        <Text style={styles.searchText}>Jump to or search...</Text>
      </View>

      {/* Notification */}
      <View style={styles.notification}>
        <Text style={styles.notificationText}>Turn on push notifications?</Text>
        <Text style={styles.notificationSubText}>
          You’re not getting notifications about incoming messages on your device.
        </Text>
        <TouchableOpacity style={styles.closeButton}>
          <Text style={styles.closeButtonText}>X</Text>
        </TouchableOpacity>
      </View>

      {/* Sections */}
      <ScrollView style={styles.sections}>
        <View style={styles.section}>
          <Text style={styles.sectionTitle}>Later</Text>
          <Text style={styles.sectionSubtitle}>0 items</Text>
        </View>
        <View style={styles.section}>
          <Text style={styles.sectionTitle}>Drafts & Sent</Text>
          <Text style={styles.sectionSubtitle}>0 drafts</Text>
        </View>

        {/* Channels */}
        <Text style={styles.sectionHeader}>채널</Text>
        <View style={styles.channelList}>
          <Text style={styles.channel}># 공부</Text>
          <Text style={styles.channel}># 랜덤</Text>
          <Text style={styles.channel}># 일반</Text>
          <TouchableOpacity>
            <Text style={styles.addChannel}>+ Add channel</Text>
          </TouchableOpacity>
        </View>
      </ScrollView>

      {/* Bottom Navigation */}
      <View style={styles.bottomNav}>
        <TouchableOpacity style={styles.navItem}>
          <FontAwesome name="home" size={24} color="white" />
          <Text style={styles.navText}>Home</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.navItem}>
          <FontAwesome name="envelope" size={24} color="white" />
          <Text style={styles.navText}>DMs</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.navItem}>
          <FontAwesome name="bell" size={24} color="white" />
          <Text style={styles.navText}>Activity</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#1A1D21',
    paddingTop: 40,
  },
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingHorizontal: 16,
    paddingVertical: 12,
    backgroundColor: '#2C2F33',
  },
  teamName: {
    color: '#ccc',
    fontSize: 25,
    fontWeight: 'bold',
  },
  userIcon: {
    alignSelf: 'center',
  },
  searchBar: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 12,
    marginVertical:5,
    marginHorizontal: 16,
    borderRadius: 8,
    backgroundColor: '#33363B',
  },
  searchText: {
    marginLeft: 10,
    color: '#ccc',
  },
  notification: {
    margin: 16,
    padding: 12,
    backgroundColor: '#3C3F41',
    borderRadius: 8,
  },
  notificationText: {
    color: '#ffcc00',
    fontWeight: 'bold',
  },
  notificationSubText: {
    color: 'white',
    marginTop: 4,
  },
  closeButton: {
    position: 'absolute',
    top: 10,
    right: 10,
  },
  closeButtonText: {
    color: 'white',
    fontWeight: 'bold',
  },
  sections: {
    flex: 1,
  },
  section: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 16,
    borderBottomWidth: 1,
    borderBottomColor: '#2C2F33',
  },
  sectionTitle: {
    color: 'white',
    fontWeight: 'bold',
  },
  sectionSubtitle: {
    color: '#777',
  },
  sectionHeader: {
    color: '#aaa',
    marginTop: 16,
    marginLeft: 16,
  },
  channelList: {
    margin: 16,
  },
  channel: {
    color: 'white',
    paddingVertical: 8,
  },
  addChannel: {
    color: '#888',
    paddingVertical: 8,
  },
  bottomNav: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    paddingVertical: 10,
    backgroundColor: '#2C2F33',
  },
  navItem: {
    alignItems: 'center',
  },
  navText: {
    color: 'white',
    fontSize: 12,
    marginTop: 4,
  },
});
